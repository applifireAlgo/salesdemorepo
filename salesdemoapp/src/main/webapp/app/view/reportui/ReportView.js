Ext.define('Salesdemoapp.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Salesdemoapp.view.reportui.querycriteria.QueryCriteriaView',
			'Salesdemoapp.view.reportui.datachart.DataChartViewTab',
			'Salesdemoapp.view.reportui.datachart.DataChartViewPanel',
			'Salesdemoapp.view.reportui.ReportViewController' ,
			'Salesdemoapp.view.fw.MainDataPointPanel',
			'Salesdemoapp.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
