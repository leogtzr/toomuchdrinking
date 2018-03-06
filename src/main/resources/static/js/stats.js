$(document).ready(function() {
  $.ajax({
    data: {},
    method: 'GET',
    url: 'mlsperday',
    async: false
  })
  .done(function(data) {
    renderChart(data);
  })
  .fail(function(jqXHR, textStatus) {
    alert("Error retrieving stats: " + textStatus);
  });
});

function renderChart(drinks) {
  if (drinks != null && drinks.ok === true) {
    var mlsperday = drinks.mls;
    var dates = [];
    var mls = [];

    for (var i = 0; i < mlsperday.length; i++) {
      mls.push(mlsperday[i].mls);
      dates.push(mlsperday[i].drinkDate);
    }

    var datapoints = mls;
    var config = {
      type: 'line',
      data: {
        labels: dates,
        datasets: [{
          label: 'Consumed milliliters',
          data: datapoints,
          //borderColor: window.chartColors.red,
          backgroundColor: 'rgba(255, 0, 0, 1)',
          fill: false,
          cubicInterpolationMode: 'monotone'
        }]
      },
      options: {
        responsive: true,
        title: {
          display: true,
          text: 'Consumed Alcohol'
        },
        tooltips: {
          mode: 'index'
        },
        scales: {
          xAxes: [{
            display: true,
            scaleLabel: {
              display: true
            }
          }],
          yAxes: [{
            display: true,
            scaleLabel: {
              display: true,
              labelString: 'Milliliters'
            },
            ticks: {
              suggestedMin: 0,
              suggestedMax: 10,
            }
          }]
        }
      }
    };

    window.onload = function() {
      var ctx = document.getElementById('canvas').getContext('2d');
      window.myLine = new Chart(ctx, config);
    };

  }
}