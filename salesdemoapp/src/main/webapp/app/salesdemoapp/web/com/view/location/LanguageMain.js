Ext.define('Salesdemoapp.salesdemoapp.web.com.view.location.LanguageMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "LanguageMainController",
     "restURL": "/Language",
     "defaults": {
          "split": true
     },
     "requires": ["Salesdemoapp.salesdemoapp.shared.com.model.location.LanguageModel", "Salesdemoapp.salesdemoapp.web.com.controller.location.LanguageMainController", "Salesdemoapp.salesdemoapp.shared.com.viewmodel.location.LanguageViewModel"],
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
               "displayName": "Language",
               "name": "LanguageTreeContainer",
               "itemId": "LanguageTreeContainer",
               "restURL": "/Language",
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
                    "itemId": "LanguageTree",
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
                    "viewModel": "LanguageViewModel",
                    "xtype": "form",
                    "displayName": "Language",
                    "title": "Language",
                    "name": "Language",
                    "itemId": "Language",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "languageId",
                         "itemId": "languageId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Language Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Language Id<font color='red'> *<\/font>",
                         "fieldId": "E3C16249-BA85-4F2D-84B9-E1664A8F564A",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "languageId",
                         "bind": "{languageId}"
                    }, {
                         "name": "language",
                         "itemId": "language",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Language",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Language<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C9AA5370-7C63-4537-8CA4-0B7FA8991085",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "language",
                         "bind": "{language}",
                         "columnWidth": 0.5
                    }, {
                         "name": "languageType",
                         "itemId": "languageType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Language Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Language Type",
                         "fieldId": "546EFA75-4DA2-44B3-AC0F-6559BE4D00BF",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "languageType",
                         "bind": "{languageType}",
                         "columnWidth": 0.5
                    }, {
                         "name": "languageDescription",
                         "itemId": "languageDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Description",
                         "fieldId": "2375269D-6E1D-495A-A612-62543E976AE9",
                         "bindable": "languageDescription",
                         "bind": "{languageDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "languageIcon",
                         "itemId": "languageIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon",
                         "fieldId": "461CF953-C0F4-40D9-AF60-195FA9D66189",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "languageIcon",
                         "bind": "{languageIcon}",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha2",
                         "itemId": "alpha2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Alpha 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Alpha 2",
                         "fieldId": "56F37DD3-9184-4A07-BC88-2F32853DAD9C",
                         "minLength": "0",
                         "maxLength": "2",
                         "bindable": "alpha2",
                         "bind": "{alpha2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha3",
                         "itemId": "alpha3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Alpha 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Alpha 3",
                         "fieldId": "E7FC74CB-B95F-4F27-9CBA-D8FDFEE5856A",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "alpha3",
                         "bind": "{alpha3}",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha4",
                         "itemId": "alpha4",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Alpha 4",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Alpha 4",
                         "fieldId": "D07106FE-D1D9-4887-B790-18CBAD8CA609",
                         "minLength": "0",
                         "maxLength": "4",
                         "bindable": "alpha4",
                         "bind": "{alpha4}",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha4parentid",
                         "itemId": "alpha4parentid",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Aplha4 Parent Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Aplha4 Parent Id",
                         "fieldId": "36E9E3C8-2723-44E4-ACD8-DE6A49C3A003",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "alpha4parentid",
                         "bind": "{alpha4parentid}",
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
                         "fieldId": "81EE7CF0-BF45-4D78-BDEF-4084AC0F1FD4",
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
                         "customId": 22,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 22,
                              "customId": 407
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 22,
                              "customId": 408,
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
                              "parentId": 22,
                              "customId": 409,
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
                    "displayName": "Language",
                    "title": "Details Grid",
                    "name": "LanguageGrid",
                    "itemId": "LanguageGrid",
                    "restURL": "/Language",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Language Id",
                         "dataIndex": "languageId",
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
                         "header": "Language",
                         "dataIndex": "language",
                         "flex": 1
                    }, {
                         "header": "Language Type",
                         "dataIndex": "languageType",
                         "flex": 1
                    }, {
                         "header": "Description",
                         "dataIndex": "languageDescription",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "languageIcon",
                         "flex": 1
                    }, {
                         "header": "Alpha 2",
                         "dataIndex": "alpha2",
                         "flex": 1
                    }, {
                         "header": "Alpha 3",
                         "dataIndex": "alpha3",
                         "flex": 1
                    }, {
                         "header": "Alpha 4",
                         "dataIndex": "alpha4",
                         "flex": 1
                    }, {
                         "header": "Aplha4 Parent Id",
                         "dataIndex": "alpha4parentid",
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
               "viewModel": "LanguageViewModel",
               "xtype": "form",
               "displayName": "Language",
               "title": "Language",
               "name": "Language",
               "itemId": "Language",
               "bodyPadding": 10,
               "items": [{
                    "name": "languageId",
                    "itemId": "languageId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Language Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Language Id<font color='red'> *<\/font>",
                    "fieldId": "E3C16249-BA85-4F2D-84B9-E1664A8F564A",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "languageId",
                    "bind": "{languageId}"
               }, {
                    "name": "language",
                    "itemId": "language",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Language",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Language<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C9AA5370-7C63-4537-8CA4-0B7FA8991085",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "language",
                    "bind": "{language}",
                    "columnWidth": 0.5
               }, {
                    "name": "languageType",
                    "itemId": "languageType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Language Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Language Type",
                    "fieldId": "546EFA75-4DA2-44B3-AC0F-6559BE4D00BF",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "languageType",
                    "bind": "{languageType}",
                    "columnWidth": 0.5
               }, {
                    "name": "languageDescription",
                    "itemId": "languageDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Description",
                    "fieldId": "2375269D-6E1D-495A-A612-62543E976AE9",
                    "bindable": "languageDescription",
                    "bind": "{languageDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "languageIcon",
                    "itemId": "languageIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Icon",
                    "fieldId": "461CF953-C0F4-40D9-AF60-195FA9D66189",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "languageIcon",
                    "bind": "{languageIcon}",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha2",
                    "itemId": "alpha2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Alpha 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Alpha 2",
                    "fieldId": "56F37DD3-9184-4A07-BC88-2F32853DAD9C",
                    "minLength": "0",
                    "maxLength": "2",
                    "bindable": "alpha2",
                    "bind": "{alpha2}",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha3",
                    "itemId": "alpha3",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Alpha 3",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Alpha 3",
                    "fieldId": "E7FC74CB-B95F-4F27-9CBA-D8FDFEE5856A",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "alpha3",
                    "bind": "{alpha3}",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha4",
                    "itemId": "alpha4",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Alpha 4",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Alpha 4",
                    "fieldId": "D07106FE-D1D9-4887-B790-18CBAD8CA609",
                    "minLength": "0",
                    "maxLength": "4",
                    "bindable": "alpha4",
                    "bind": "{alpha4}",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha4parentid",
                    "itemId": "alpha4parentid",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Aplha4 Parent Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Aplha4 Parent Id",
                    "fieldId": "36E9E3C8-2723-44E4-ACD8-DE6A49C3A003",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "alpha4parentid",
                    "bind": "{alpha4parentid}",
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
                    "fieldId": "81EE7CF0-BF45-4D78-BDEF-4084AC0F1FD4",
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
                    "customId": 22,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 22,
                         "customId": 407
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 22,
                         "customId": 408,
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
                         "parentId": 22,
                         "customId": 409,
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