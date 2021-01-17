/*Gráfico TopList de Vendas*/

	
	var campoTopListId = new Array();
	var campoTopListNome = new Array(); 
	var campoTopListSaida = new Array();
		
	// pega id de toplist
	for(var i=0; i < divTopListId.childNodes.length; i++){
		campoTopListId[i] = divTopListId.childNodes[i].value;
	}
	
	// pega nome do toplist
	for(var i=0; i < divTopListNome.childNodes.length; i++){
		campoTopListNome[i] = divTopListNome.childNodes[i].value;
	}
	
	// pega saída do toplist
	for(var i=0; i<divTopListSaida.childNodes.length; i++){
		campoTopListSaida[i] = divTopListSaida.childNodes[i].value;
	}
	 
	// chart
		var randomScalingFactor = function() {
			return Math.round(Math.random() * 100);
		};

		var chartColors = window.chartColors;
		var color = Chart.helpers.color;
		var config = {
			data: {
				datasets: [{
					data: campoTopListSaida,
					backgroundColor: [
						color(chartColors.red).alpha(0.5).rgbString(),
						color(chartColors.orange).alpha(0.5).rgbString(),
						color(chartColors.yellow).alpha(0.5).rgbString(),
						color(chartColors.green).alpha(0.5).rgbString(),
						color(chartColors.blue).alpha(0.5).rgbString(),
					],
					label: 'My dataset' // for legend
				}],
	
				labels: campoTopListNome

			},
			options: {
				responsive: true,
				legend: {
					position: 'right',
				},
				title: {
					display: true,
					text: ' '
				},
				scale: {
					ticks: {
						beginAtZero: true
					},
					reverse: false
				},
				animation: {
					animateRotate: false,
					animateScale: true
				}
			}
		};


		var colorNames = Object.keys(window.chartColors);
		
	