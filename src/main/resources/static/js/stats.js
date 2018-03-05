$(function () {

    var rs = $.ajax(
        {
            data: {},
            method: 'GET',
            url: 'mlsperday',
            async: false
        }
    );

    var drinks = JSON.parse(rs.responseText);
    if (drinks != null && drinks.ok) {

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
                    backgroundColor: 'rgba(0, 0, 0, 0)',
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
                            labelString: 'Value'
                        },
                        ticks: {
                            suggestedMin: -10,
                            suggestedMax: 200,
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

});