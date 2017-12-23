<?php
   $con = mysqli_connect("localhost","root","sqlrootpw","dbproject");
    if(!$con)
    {
        echo "MySQL 접속 에러 : ";
        echo mysqli_connect_error();
        exit();
    }
    mysqli_set_charset($con, "utf8");
    $userNum = (int)$_POST['userNum'];
    $userOrderNum = (int)$_POST['orderNum'];

    //$id = 'test';

    if($userNum != ''){

        $result = mysqli_query($con, "SELECT * FROM orderInfo WHERE userNum = $userNum AND complete = 0");

        if($result){
            $response = array();
            $orderNum;
            $fullMenu ="";
            $count ="";
            $size = "";
            $wait;
            $date;
            $total;
            while($row = mysqli_fetch_array($result)){
                $orderNum = (int)$row['orderNum'];
                $date = $row['orderDate'];
                $total = $row['totalPrice'];
                $result2 = mysqli_query($con, "SELECT COUNT(*) FROM orderInfo WHERE orderNum <= $orderNum AND complete = 0");
                $row2 = mysqli_fetch_array($result2);
                $wait = $row2['COUNT(*)'];
            }
            
            $coffeeResult = mysqli_query($con, "SELECT C.name, O.type, O.size, O.count  FROM
                orderCoffeeItem AS O
                JOIN coffee AS C ON O.menuId = C.id
                WHERE O.orderNum = $orderNum");

            if($coffeeResult){
                while($coffeeRow = mysqli_fetch_array($coffeeResult)){
                    if($coffeeRow['type'] == "H")
                        $fullMenu = $fullMenu . $coffeeRow["name"] . "(HOT), ";
                    else
                        $fullMenu = $fullMenu . $coffeeRow["name"] . "(ICE), ";

                    $count = $count . $coffeeRow["count"] . ", ";
                    $size = $size . $coffeeRow["size"] . ", ";
                }
            }

            $beverageResult = mysqli_query($con, "SELECT B.name, O.type, O.size, O.count  FROM
                orderBeverageItem AS O
                JOIN beverage AS B ON O.menuId = B.id
                WHERE O.orderNum = $orderNum");
            
            if($beverageResult){
                while($beverageRow = mysqli_fetch_array($beverageResult)){
                    if($beverageRow['type'] == "H")
                        $fullMenu = $fullMenu . $beverageRow["name"] . "(HOT), ";
                    else
                        $fullMenu = $fullMenu . $beverageRow["name"] . "(ICE), ";

                    $count = $count . $beverageRow["count"] . ", ";
                    $size = $size . $beverageRow["size"] . ", ";
                }
            }

            $dessertResult = mysqli_query($con, "SELECT D.name, O.count  FROM
                orderDessertItem AS O
                JOIN dessert AS D ON O.menuId = D.id
                WHERE O.orderNum = $orderNum");
            
            if($dessertResult){
                while($dessertRow = mysqli_fetch_array($dessertResult)){
                    $fullMenu = $fullMenu . $dessertRow["name"] . ", ";

                    $count = $count . $coffeeRow["count"] . ", " ;
                    $size = $size . ", ";
                }
            }

            array_push($response, array('date' => $date,
            'orderNum' => $orderNum,
            'fullMenu' => $fullMenu,
            'count' => $count,
            'size' => $size,
            'total' => $total,
            'wait' => $wait,
            ));
            echo json_encode($response, JSON_UNESCAPED_UNICODE);
        }

    } else if($userOrderNum != ''){

        $result = mysqli_query($con, "SELECT * FROM orderInfo WHERE orderNum = $userOrderNum");
        $row = mysqli_fetch_array($result);
        $response2 = array();
        if((int)$row['complete'] == 0){
            $result2 = mysqli_query($con, "SELECT COUNT(*) FROM orderInfo WHERE orderNum <= $userOrderNum AND complete = 0");
            $row2 = mysqli_fetch_array($result2);
            array_push($response2, array('complete' => '0',
                'wait' => $row2['COUNT(*)'],));
        }else if((int)$row['complete'] == 1){
            array_push($response2, array('complete' => '1',));
        }else if((int)$row['complete'] == 2){
            array_push($response2, array('complete' => '2',));
        }

            echo json_encode($response2);
    }
   // echo json_encode($response);
    mysqli_close($con);
?>
