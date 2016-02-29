<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="css/jquery.seat-charts.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="js/jquery.seat-charts.js"></script>
		<script type="text/javascript">
			var price = 80;
$(document).ready(function() { 
    var $cart = $('#selected-seats'), 
    $counter = $('#counter'), 
    $total = $('#total');
     
    window.sc = $('#seat-map').seatCharts({ 
        map: [  
            'aaaaaaaaaa', 
            'aaaaaaaaaa', 
            '__________', 
            'aaaaaaaa__', 
            'aaaaaaaaaa', 
            'aaaaaaaaaa', 
            'aaaaaaaaaa', 
            'aaaaaaaaaa', 
            'aaaaaaaaaa', 
            'aa__aa__aa' 
        ], 
        legend : {
            node : $('#legend'), 
            items : [ 
                [ 'a', 'available',   '可选' ], 
                [ 'a', 'unavailable', '不可选'] 
            ]                     
        }, 
        click: function () {
        	if(sc.find('selected').seats[0]){
        		return this.style();
        	} else if (this.status() == 'available') { 
                $('<li>'+(this.settings.row+1)+'排'+this.settings.label+'座</li>') 
                    .attr('id', 'cart-item-'+this.settings.id) 
                    .data('seatId', this.settings.id) 
                    .appendTo($cart); 
 
                $counter.text(sc.find('selected').length+1); 
                $total.text(recalculateTotal(sc)+price); 
                             
                return 'selected'; 
            } else if (this.status() == 'selected') { 
           
                $counter.text(sc.find('selected').length-1); 
             
                $total.text(recalculateTotal(sc)-price); 
                         
                
                $('#cart-item-'+this.settings.id).remove(); 
              
                return 'available'; 
            } else if (this.status() == 'unavailable') { 
                return 'unavailable'; 
            } else { 
                return this.style(); 
            } 
        } 
    }); 

    sc.get([ ${seat} ]).status('unavailable'); 
         
}); 
function recalculateTotal(sc) { 
    var total = 0; 
    sc.find('selected').each(function () { 
        total += price; 
    }); 
             
    return total; 
} 
		</script>

		<style type="text/css">
			.front {
				width: 300px;
				margin: 5px 32px 45px 32px;
				background-color: #f0f0f0;
				color: #666;
				text-align: center;
				padding: 3px;
				border-radius: 5px;
			}
			.booking-details {
				float: right;
				position: relative;
				width: 200px;
				height: 450px;
			}
			.booking-details h3 {
				margin: 5px 5px 0 0;
				font-size: 16px;
			}
			.booking-details p {
				line-height: 26px;
				font-size: 16px;
				color: #999
			}
			.booking-details p span {
				color: #666
			}
			div.seatCharts-cell {
				color: #182C4E;
				height: 25px;
				width: 25px;
				line-height: 25px;
				margin: 3px;
				float: left;
				text-align: center;
				outline: none;
				font-size: 13px;
			}
			div.seatCharts-seat {
				color: #fff;
				cursor: pointer;
				-webkit-border-radius: 5px;
				-moz-border-radius: 5px;
				border-radius: 5px;
			}
			div.seatCharts-row {
				height: 35px;
			}
			div.seatCharts-seat.available {
				background-color: #B9DEA0;
			}
			div.seatCharts-seat.focused {
				background-color: #76B474;
				border: none;
			}
			div.seatCharts-seat.selected {
				background-color: #E6CAC4;
			}
			div.seatCharts-seat.unavailable {
				background-color: #472B34;
				cursor: not-allowed;
			}
			div.seatCharts-container {
				border-right: 1px dotted #adadad;
				width: 400px;
				padding: 20px;
				float: left;
			}
			div.seatCharts-legend {
				padding-left: 0px;
				position: absolute;
				bottom: 16px;
			}
			ul.seatCharts-legendList {
				padding-left: 0px;
			}
			.seatCharts-legendItem {
				float: left;
				width: 90px;
				margin-top: 10px;
				line-height: 2;
			}
			span.seatCharts-legendDescription {
				margin-left: 5px;
				line-height: 30px;
			}
			.checkout-button {
				display: block;
				width: 80px;
				height: 24px;
				line-height: 20px;
				margin: 10px auto;
				border: 1px solid #999;
				font-size: 14px;
				cursor: pointer
			}
			#selected-seats {
				max-height: 150px;
				overflow-y: auto;
				overflow-x: none;
				width: 200px;
			}
			#selected-seats li {
				float: left;
				width: 72px;
				height: 26px;
				line-height: 26px;
				border: 1px solid #d3d3d3;
				background: #f7f7f7;
				margin: 6px;
				font-size: 14px;
				font-weight: bold;
				text-align: center
			}
		</style>
	</head>

	<body>
		<div class="demo">
			<div id="seat-map">
				<div class="front">屏幕</div>
			</div>
			<div class="booking-details">
				<p>电影：<span>星球大战3D</span></p>
				<p>时间<span>1月17日 21:00</span></p>
				<p>座位：</p>
				<ul id="selected-seats"></ul>
				<p>票数：<span id="counter">0</span></p>
				<p>总计：<b>￥<span id="total">0</span></b></p>

<form id="buyit" action="BookServlet" methord="post">
<input id="row" name="row" type="hidden" />
<input id="column" name="column" type="hidden" />

<input class="checkout-button" type="submit" value="确认购买" />
				</form>
				<script>
				$(function(){
					
					$("#buyit").on('submit', function(){
						$("#column").val(sc.find('selected').seats[0].settings.column+1);
						$("#row").val(sc.find('selected').seats[0].settings.row +1);
					});
				})
				</script>
				<div id="legend"></div>
			</div>
		</div>
	</body>
<a href="javascript:history.back()">返回上一页</a>
</html>