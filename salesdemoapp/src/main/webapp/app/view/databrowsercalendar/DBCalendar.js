Ext.define('Salesdemoapp.view.databrowsercalendar.DBCalendar', {
	extend : 'Salesdemoapp.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Salesdemoapp.view.databrowsercalendar.DBCalendarController',
	             'Salesdemoapp.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
