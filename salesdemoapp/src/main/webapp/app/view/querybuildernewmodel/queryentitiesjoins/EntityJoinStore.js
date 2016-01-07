Ext.define('Salesdemoapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Salesdemoapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Salesdemoapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
