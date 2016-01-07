Ext.define('Salesdemoapp.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesStore', {
    extend: 'Ext.data.Store',
   // requires:['Salesdemoapp.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel'],
    autoSync: false,
    model: 'Salesdemoapp.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel',
    data:[]
});
