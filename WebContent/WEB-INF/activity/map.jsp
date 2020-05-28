<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>SkillExchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/leaflet.css" />
<script src="js/leaflet.js"></script>
<style>
* {
	font-family: 微軟正黑體;
}

.a {
	background-color: #FFECF5;
}

li a {
	display: block
}

li a:hover {
	background-color: #000000;
	display: block
}

* {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<!-- 	<div id="layoutSidenav"> -->
	<%-- 		<%-- 		<jsp:include page="/fragment/left.jsp" /> --%>
	<!-- 		<div id="layoutSidenav_content"> -->
	<!-- 			<main class="a"> -->
	<div style="width: 1000px; height: 55px;">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#"
					id="place">本活動地點</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick=findplace(0)>全部</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick=findplace(1)>音樂</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick=findplace(2)>語言</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick=findplace(3)>運動</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick=findplace(4)>電腦</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					onclick=findplace(5)>其他</a></li>
			</ul>
		</nav>
	</div>

	<div id="mapid" style="width: 1000px; height: 685px;"></div>



	<!-- 		</div> -->
	<!-- 	</div> -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/datatables-demo.js"></script>
	<script>
		
	</script>
	<script>

       var btn=document.getElementById("place");
       btn.onclick=initial;
       window.onload=initial;
       var mymap = L.map('mapid').setView([25.043631, 121.457477 ], 11);		
		var tile = L.tileLayer(
				'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
					minZoom : 8,
					maxZoom : 16
				}).addTo(mymap);
       var sitemarker = new L.layerGroup();
      
       function initial(){
		
	    sitemarker.clearLayers(); 
	    if( ${search.lat}+"1" != "1" && ${search.long1}+"1" != "1" ){
		var marker = L.marker([ ${search.lat}, ${search.long1}]).bindPopup('<h4>'+"${search.title}"+'</h4>')
				.addTo(sitemarker).on('mouseover', function() {
					this.openPopup();
				}).on('mouseout', function (e) {
		            this.closePopup();
		        });
		sitemarker.addTo(mymap);
	    }

       }
		mymap.locate({setView: true, watch: true});
		// 成功監聽到使用者的位置時觸發
		 var Icon = L.icon({
    	    iconUrl: 'activityimg/position.png',
    	    iconSize:     [38, 55], // size of the icon
    	    shadowSize:   [50, 64], // size of the shadow
//     	    iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
//     	    shadowAnchor: [4, 62],  // the same for the shadow
//     	    popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
    	});
		var myLocation;
		mymap.on('locationfound', function(e) {
			 myLocation = e.latlng
//	 		  var radius = e.accuracy / 2;
			  L.marker(e.latlng,  {icon: Icon}).addTo(mymap).bindPopup("<h4>目前位置</h4>").openPopup();
//	 		  L.circle(e.latlng, radius).addTo(mymap);
			  
			});
		mymap.on('locationerror', function(e) {
			  console.log('定位出错=====>', e);
			});

   
	
	var popup = L.popup();
	mymap.on('dblclick', onMapClick);
	function onMapClick(e) {
	    // 顯示點擊區域的經緯度
	    var clickplace = L.latLng(e.latlng)
	      popup
          .setLatLng(e.latlng)
          .setContent("<h5>座標：" + e.latlng.toString().substr(6,27)+"<br>距離目前位置:"+(myLocation.distanceTo(clickplace)/1000).toString().substr(0,4)+"km</h5>")
          .openOn(mymap);

	}

		function findplace(number){
			var category;
               if(number==1){
            	   category="音樂";
                }else if(number==2){
                   category="語言";
                }else if(number==3){
                   category="運動";
                }else if(number==4){
                   category="電腦";
                }else if(number==5){
                   category="其他";
                }else if(number==0){
                   category="全部";
                }
            var number = new L.layerGroup();
           	$.ajax({
				url : "FindPlace", //請求的url地址
				dataType : "json", //返回格式為json
				async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
				data : {
					"category":category
				}, //引數值
				type : "GET", //請求方式
				success : function(req) {
					console.log(req);
// 					var obj= JSON.parse(req);
                    sitemarker.clearLayers(); 
					for(var i=0; i<req.length; i++){
						if(req[i].lat+"1" !="1" && req[i].long1+"1" !="1"){
					    L.marker([ req[i].lat,req[i].long1 ]).bindPopup('<h4>'+req[i].title+'</h4>')
						.addTo(sitemarker).on('mouseover', function() {
							this.openPopup();
						}).on('mouseout', function (e) {
				            this.closePopup();
				        });
						}
					}
// 					mymap.setView([ req[1].lat,req[1].long1 ], 11)
					sitemarker.addTo(mymap);
				},
				complete : function() {
					//請求完成的處理
				},
				error : function() {
					console.log("出錯了!")
				}
			});
//            	mymap.removeLayer(sitemarker);
			}
	</script>
</body>
</html>