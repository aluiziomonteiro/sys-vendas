/*Gráfico de Vendas vs Investimento*/

	var campoData = new Array();
	var campoAno = new Array(); 
	var campoMes = new Array();
	var campoValor = new Array();
	var campoInvestimentos = new Array();
	
	var ano; 
	var mes;
	var valor = 0.00;
	var investimento = 0.00;
	
	// pega investimento R$
	for(var i=0; i < divInvestimentos.childNodes.length; i++){
		investimento = parseFloat(divInvestimentos.childNodes[i].value).toFixed(2);
		console.log(investimento);
		campoInvestimentos[i] = (investimento);
	}
	
	
	// pega valor R$
	for(var i=0; i < divValor.childNodes.length; i++){
		valor = parseFloat(divValor.childNodes[i].value);
		campoValor[i] = valor;
	}
	
	// pega mês
	for(var i=0; i<divMes.childNodes.length; i++){
		campoMes[i] = divMes.childNodes[i].value;
	}
	
	// pega ano
	for(var i=0; i < divAno.childNodes.length; i++){
		campoAno[i] = divAno.childNodes[i].value;
	} 
	
	//Monta a Data
	for(var i=0; i < 12; i++){
		ano = campoAno[i];
		mes = campoMes[i];
		var fulldata;
		
		//testa se data é null
		if(ano == null){
			fulldata = "..."
		} else {
			fulldata = mes+"/"+ano;
		}

		//popula array com data montada
		campoData[i] = fulldata;
	}
	
	
	
	 //chart
	 //formatador
	 var utils = Samples.utils;
		var inputInvestimento = {
				data: campoInvestimentos,
				min: 0,
				max: campoValor[campoInvestimentos.length-1],
				count: 12,
				decimals: 2
			
			
		};
		
		var inputValor = {
				data: campoValor,
				min: 0,
				max: campoValor[campoValor.length-1],
				count: 12,
				decimals: 2,
				
			};
		
		//geravalor
		function geraValor() {
			return utils.numbers(inputValor);
		}
		
		//geraIvestimento
		function geraIvestimento() {
			return utils.numbers(inputInvestimento);
		}
		//fim formatador
		utils.srand(42);
		
		var chartData = {
			labels: campoData,
			datasets: [{
				type: 'bar',
				fill: true,
				label: 'Vendas',
				backgroundColor: window.chartColors.green,
				data: campoValor,
				/*data: geraValor(),*/
				borderColor: 'white',
				borderWidth: 2
			}, {
				type: 'bar',
				label: 'Investimentos',
				backgroundColor: window.chartColors.red,
				data: campoInvestimentos,
				/*data: geraIvestimento(),*/
			}]

		};
		
		
		
		window.onload = function() {
			
			var ctx1 = document.getElementById('canvas').getContext('2d');
			window.myMixedChart = new Chart(ctx1, {
				type: 'bar',
				data: chartData,
				options: {
					responsive: true,
					title: {
						display: false,
						text: 'Chart.js Combo Bar Line Chart'
					},
					tooltips: {
						mode: 'index',
						intersect: true
					}
				}
			});
			
			var ctx = document.getElementById('chart-area');
			window.myPolarArea = Chart.PolarArea(ctx, config);
			
		};

		document.getElementById('randomizeData').addEventListener('click', function() {
			chartData.datasets.forEach(function(dataset) {
				dataset.data = dataset.data.map(function() {
					return randomScalingFactor();
				});
			});
			window.myMixedChart.update();
		});
		


	