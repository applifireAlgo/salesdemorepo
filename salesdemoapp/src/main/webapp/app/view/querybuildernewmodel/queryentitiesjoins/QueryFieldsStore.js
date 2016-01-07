Ext.define('Salesdemoapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Salesdemoapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Salesdemoapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
