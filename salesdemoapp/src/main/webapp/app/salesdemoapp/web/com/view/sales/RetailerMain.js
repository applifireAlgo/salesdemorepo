Ext.define('Salesdemoapp.salesdemoapp.web.com.view.sales.RetailerMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "RetailerMainController",
     "restURL": "/Retailer",
     "defaults": {
          "split": true
     },
     "requires": ["Salesdemoapp.salesdemoapp.shared.com.model.sales.RetailerModel", "Salesdemoapp.salesdemoapp.web.com.controller.sales.RetailerMainController", "Salesdemoapp.salesdemoapp.shared.com.model.sales.DistributorModel", "Salesdemoapp.salesdemoapp.shared.com.viewmodel.sales.RetailerViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Retailer",
               "name": "RetailerTreeContainer",
               "itemId": "RetailerTreeContainer",
               "restURL": "/Retailer",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "RetailerTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "RetailerViewModel",
                    "xtype": "form",
                    "displayName": "Retailer",
                    "title": "Retailer",
                    "name": "Retailer",
                    "itemId": "Retailer",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "retailercode",
                         "itemId": "retailercode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Retailer code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Retailer code<font color='red'> *<\/font>",
                         "fieldId": "5B315D5D-BC4E-4099-947C-5E52C2401D5C",
                         "minLength": "0",
                         "maxLength": "256",
                         "hidden": true,
                         "value": "",
                         "bindable": "retailercode",
                         "bind": "{retailercode}"
                    }, {
                         "name": "retailername",
                         "itemId": "retailername",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Retailer name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Retailer name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "905AA465-8629-4BE3-A675-6E9F1EB2D470",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "retailername",
                         "bind": "{retailername}",
                         "columnWidth": 0.5
                    }, {
                         "name": "distributorcode",
                         "itemId": "distributorcode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Distributor code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Distributor code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F3CB09F6-9217-43F5-8C9C-CE95F85363A3",
                         "restURL": "Distributor",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.DistributorModel"
                         },
                         "bindable": "distributorcode",
                         "bind": "{distributorcode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "559D1117-FB9C-4CFE-8DC1-7A4709AE9151",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 811,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 811,
                              "customId": 272
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 811,
                              "customId": 273,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 811,
                              "customId": 274,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Retailer",
                    "title": "Details Grid",
                    "name": "RetailerGrid",
                    "itemId": "RetailerGrid",
                    "restURL": "/Retailer",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Retailer code",
                         "dataIndex": "retailercode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Retailer name",
                         "dataIndex": "retailername",
                         "flex": 1
                    }, {
                         "header": "Distributor code",
                         "dataIndex": "distributorcode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "RetailerViewModel",
               "xtype": "form",
               "displayName": "Retailer",
               "title": "Retailer",
               "name": "Retailer",
               "itemId": "Retailer",
               "bodyPadding": 10,
               "items": [{
                    "name": "retailercode",
                    "itemId": "retailercode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Retailer code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Retailer code<font color='red'> *<\/font>",
                    "fieldId": "5B315D5D-BC4E-4099-947C-5E52C2401D5C",
                    "minLength": "0",
                    "maxLength": "256",
                    "hidden": true,
                    "value": "",
                    "bindable": "retailercode",
                    "bind": "{retailercode}"
               }, {
                    "name": "retailername",
                    "itemId": "retailername",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Retailer name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Retailer name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "905AA465-8629-4BE3-A675-6E9F1EB2D470",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "retailername",
                    "bind": "{retailername}",
                    "columnWidth": 0.5
               }, {
                    "name": "distributorcode",
                    "itemId": "distributorcode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Distributor code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Distributor code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F3CB09F6-9217-43F5-8C9C-CE95F85363A3",
                    "restURL": "Distributor",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.DistributorModel"
                    },
                    "bindable": "distributorcode",
                    "bind": "{distributorcode}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "559D1117-FB9C-4CFE-8DC1-7A4709AE9151",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 811,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 811,
                         "customId": 272
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 811,
                         "customId": 273,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 811,
                         "customId": 274,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});