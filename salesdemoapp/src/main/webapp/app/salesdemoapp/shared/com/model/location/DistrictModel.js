Ext.define('Salesdemoapp.salesdemoapp.shared.com.model.location.DistrictModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "districtId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "countryid",
          "reference": "Country",
          "defaultValue": ""
     }, {
          "name": "stateid",
          "reference": "State",
          "defaultValue": ""
     }, {
          "name": "regionid",
          "reference": "Region",
          "defaultValue": ""
     }, {
          "name": "name",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "code2",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "districtDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "districtFlag",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "districtLatitude",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "districtLongitude",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});