Ext.define('Salesdemoapp.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Salesdemoapp.view.reportui.datachart.DataChartTController',
			'Salesdemoapp.view.reportui.datachart.datagrid.DataGridView','Salesdemoapp.view.reportui.datachart.chart.ChartTabView','Salesdemoapp.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',

	margin : '0 0 0 0',
	initComponent : function() {
		/*this.items */

		this.callParent(arguments);
	},
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:function(me){
        	me.setActiveTab(me.items.items[0]);
        }
	}

});