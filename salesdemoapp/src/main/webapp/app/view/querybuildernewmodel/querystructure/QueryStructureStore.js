Ext.define('Salesdemoapp.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Salesdemoapp.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Salesdemoapp.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
