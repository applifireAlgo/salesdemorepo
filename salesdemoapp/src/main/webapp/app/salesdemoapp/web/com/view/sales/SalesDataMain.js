Ext.define('Salesdemoapp.salesdemoapp.web.com.view.sales.SalesDataMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "SalesDataMainController",
     "restURL": "/SalesData",
     "defaults": {
          "split": true
     },
     "requires": ["Salesdemoapp.salesdemoapp.shared.com.model.sales.SalesDataModel", "Salesdemoapp.salesdemoapp.web.com.controller.sales.SalesDataMainController", "Salesdemoapp.salesdemoapp.shared.com.model.sales.ChannelModel", "Salesdemoapp.salesdemoapp.shared.com.model.sales.RetailerModel", "Salesdemoapp.salesdemoapp.shared.com.model.sales.MaterialModel", "Salesdemoapp.salesdemoapp.shared.com.model.sales.BrandModel", "Salesdemoapp.salesdemoapp.shared.com.model.sales.CategoryModel", "Salesdemoapp.salesdemoapp.shared.com.viewmodel.sales.SalesDataViewModel"],
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
               "displayName": "SalesData",
               "name": "SalesDataTreeContainer",
               "itemId": "SalesDataTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "SalesDataTree",
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
                    "layout": "fit",
                    "autoScroll": false,
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick"
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
                    "xtype": "form",
                    "displayName": "SalesData",
                    "name": "SalesData",
                    "itemId": "SalesDataForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "autoid",
                                   "itemId": "autoid",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "auto id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "auto id<font color='red'> *<\/font>",
                                   "fieldId": "515A6D3D-B446-4B13-9453-53B98637586A",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "autoid",
                                   "bind": "{autoid}"
                              }, {
                                   "name": "channelId",
                                   "itemId": "channelId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Channel",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Channel<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "27A2C46B-050E-4902-8712-538863DB3A1C",
                                   "restURL": "Channel",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.ChannelModel"
                                   },
                                   "bindable": "channelId",
                                   "columnWidth": 0.5,
                                   "bind": "{channelId}"
                              }, {
                                   "name": "reatilercode",
                                   "itemId": "reatilercode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Retailer code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Retailer code<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E485A73E-653B-487A-9A90-3A08E35E80A1",
                                   "restURL": "Retailer",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.RetailerModel"
                                   },
                                   "bindable": "reatilercode",
                                   "columnWidth": 0.5,
                                   "bind": "{reatilercode}"
                              }, {
                                   "name": "retailername",
                                   "itemId": "retailername",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Retailer name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Retailer name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "337A9952-8A19-4D79-AF92-FBA733B820FA",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "retailername",
                                   "columnWidth": 0.5,
                                   "bind": "{retailername}"
                              }, {
                                   "name": "salesdate",
                                   "itemId": "salesdate",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Sales date",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "F704EFE6-69AA-440E-B25E-52B0BD4219B0",
                                   "bindable": "salesdate",
                                   "columnWidth": 0.5,
                                   "bind": "{salesdate}",
                                   "format": "d-m-Y H:m:s",
                                   "submitFormat": "d-m-Y H:m:s"
                              }, {
                                   "name": "salesmonth",
                                   "itemId": "salesmonth",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sales month",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales month<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "850F1223-36A8-4139-86B9-16AD05E4A5C5",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "salesmonth",
                                   "columnWidth": 0.5,
                                   "bind": "{salesmonth}"
                              }, {
                                   "name": "salesyear",
                                   "itemId": "salesyear",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sales year",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales year<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C90B909A-7D19-48F8-90DE-24F44ED6302D",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "salesyear",
                                   "columnWidth": 0.5,
                                   "bind": "{salesyear}"
                              }, {
                                   "name": "salesinvoicenbr",
                                   "itemId": "salesinvoicenbr",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Sales invoice nbr",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales invoice nbr<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "EFD5C83D-CBA9-41A8-9293-4CC9761A529A",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "salesinvoicenbr",
                                   "columnWidth": 0.5,
                                   "bind": "{salesinvoicenbr}"
                              }, {
                                   "name": "materialdesc",
                                   "itemId": "materialdesc",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Material desc",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Material desc<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "FD84C53F-9A5F-4F75-BB8A-634FE6228C62",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "materialdesc",
                                   "columnWidth": 0.5,
                                   "bind": "{materialdesc}"
                              }, {
                                   "name": "branddesc",
                                   "itemId": "branddesc",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Brand desc",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Brand desc<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "9F4B06D4-56FF-4FFB-B478-AADA9C9137DD",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "branddesc",
                                   "columnWidth": 0.5,
                                   "bind": "{branddesc}"
                              }, {
                                   "name": "salesqty",
                                   "itemId": "salesqty",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sales qty",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales qty<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "1C834ABC-C457-44D6-8789-C23871DBC197",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "salesqty",
                                   "columnWidth": 0.5,
                                   "bind": "{salesqty}"
                              }, {
                                   "name": "netsalesamt",
                                   "itemId": "netsalesamt",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Net sales amt",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Net sales amt<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "162D2432-B19D-4067-9AC0-92630CBE5D1F",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "netsalesamt",
                                   "columnWidth": 0.5,
                                   "bind": "{netsalesamt}"
                              }, {
                                   "name": "grosssalesamt",
                                   "itemId": "grosssalesamt",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Gross sales amt",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Gross sales amt<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "0B018828-19E2-4783-AB98-9979C70313E2",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "grosssalesamt",
                                   "columnWidth": 0.5,
                                   "bind": "{grosssalesamt}"
                              }, {
                                   "name": "materialcode",
                                   "itemId": "materialcode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Material code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Material code<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "17DED33B-56D3-418A-8259-00B46DDC3F9C",
                                   "restURL": "Material",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.MaterialModel"
                                   },
                                   "bindable": "materialcode",
                                   "columnWidth": 0.5,
                                   "bind": "{materialcode}"
                              }, {
                                   "name": "brandcode",
                                   "itemId": "brandcode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Brand code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Brand code<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "CFAB97D5-6CF1-4275-84B5-EDEDCD58F896",
                                   "restURL": "Brand",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.BrandModel"
                                   },
                                   "bindable": "brandcode",
                                   "columnWidth": 0.5,
                                   "bind": "{brandcode}",
                                   "listeners": {
                                        "change": "onBrandcodeChange"
                                   }
                              }, {
                                   "name": "category",
                                   "itemId": "category",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Category",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Category<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E26FD5B2-7ADE-46BF-99BA-34DA082A6900",
                                   "restURL": "Category",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.CategoryModel"
                                   },
                                   "bindable": "category",
                                   "columnWidth": 0.5,
                                   "bind": "{category}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "31A73DC0-3659-4786-B7A8-083AA64ABA1A",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "viewModel": "SalesDataViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "SalesData",
                    "title": "Details Grid",
                    "name": "SalesDataGrid",
                    "itemId": "SalesDataGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "auto id",
                         "dataIndex": "autoid",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Channel",
                         "dataIndex": "channelId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Retailer code",
                         "dataIndex": "reatilercode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Retailer name",
                         "dataIndex": "retailername",
                         "flex": 1
                    }, {
                         "header": "Sales date",
                         "dataIndex": "salesdate",
                         "flex": 1
                    }, {
                         "header": "Sales month",
                         "dataIndex": "salesmonth",
                         "flex": 1
                    }, {
                         "header": "Sales year",
                         "dataIndex": "salesyear",
                         "flex": 1
                    }, {
                         "header": "Sales invoice nbr",
                         "dataIndex": "salesinvoicenbr",
                         "flex": 1
                    }, {
                         "header": "Material desc",
                         "dataIndex": "materialdesc",
                         "flex": 1
                    }, {
                         "header": "Brand desc",
                         "dataIndex": "branddesc",
                         "flex": 1
                    }, {
                         "header": "Sales qty",
                         "dataIndex": "salesqty",
                         "flex": 1
                    }, {
                         "header": "Net sales amt",
                         "dataIndex": "netsalesamt",
                         "flex": 1
                    }, {
                         "header": "Gross sales amt",
                         "dataIndex": "grosssalesamt",
                         "flex": 1
                    }, {
                         "header": "Material code",
                         "dataIndex": "materialcode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Brand code",
                         "dataIndex": "brandcode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Category",
                         "dataIndex": "category",
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
               "xtype": "form",
               "displayName": "SalesData",
               "name": "SalesData",
               "itemId": "SalesDataForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "autoid",
                              "itemId": "autoid",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "auto id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "auto id<font color='red'> *<\/font>",
                              "fieldId": "515A6D3D-B446-4B13-9453-53B98637586A",
                              "hidden": true,
                              "value": "",
                              "bindable": "autoid",
                              "bind": "{autoid}"
                         }, {
                              "name": "channelId",
                              "itemId": "channelId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Channel",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Channel<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "27A2C46B-050E-4902-8712-538863DB3A1C",
                              "restURL": "Channel",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.ChannelModel"
                              },
                              "bindable": "channelId",
                              "columnWidth": 0.5,
                              "bind": "{channelId}"
                         }, {
                              "name": "reatilercode",
                              "itemId": "reatilercode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Retailer code",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Retailer code<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E485A73E-653B-487A-9A90-3A08E35E80A1",
                              "restURL": "Retailer",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.RetailerModel"
                              },
                              "bindable": "reatilercode",
                              "columnWidth": 0.5,
                              "bind": "{reatilercode}"
                         }, {
                              "name": "retailername",
                              "itemId": "retailername",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Retailer name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Retailer name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "337A9952-8A19-4D79-AF92-FBA733B820FA",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "retailername",
                              "columnWidth": 0.5,
                              "bind": "{retailername}"
                         }, {
                              "name": "salesdate",
                              "itemId": "salesdate",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Sales date",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "F704EFE6-69AA-440E-B25E-52B0BD4219B0",
                              "bindable": "salesdate",
                              "columnWidth": 0.5,
                              "bind": "{salesdate}",
                              "format": "d-m-Y H:m:s",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "name": "salesmonth",
                              "itemId": "salesmonth",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sales month",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales month<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "850F1223-36A8-4139-86B9-16AD05E4A5C5",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "salesmonth",
                              "columnWidth": 0.5,
                              "bind": "{salesmonth}"
                         }, {
                              "name": "salesyear",
                              "itemId": "salesyear",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sales year",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales year<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C90B909A-7D19-48F8-90DE-24F44ED6302D",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "salesyear",
                              "columnWidth": 0.5,
                              "bind": "{salesyear}"
                         }, {
                              "name": "salesinvoicenbr",
                              "itemId": "salesinvoicenbr",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Sales invoice nbr",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales invoice nbr<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "EFD5C83D-CBA9-41A8-9293-4CC9761A529A",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "salesinvoicenbr",
                              "columnWidth": 0.5,
                              "bind": "{salesinvoicenbr}"
                         }, {
                              "name": "materialdesc",
                              "itemId": "materialdesc",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Material desc",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Material desc<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "FD84C53F-9A5F-4F75-BB8A-634FE6228C62",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "materialdesc",
                              "columnWidth": 0.5,
                              "bind": "{materialdesc}"
                         }, {
                              "name": "branddesc",
                              "itemId": "branddesc",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Brand desc",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Brand desc<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "9F4B06D4-56FF-4FFB-B478-AADA9C9137DD",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "branddesc",
                              "columnWidth": 0.5,
                              "bind": "{branddesc}"
                         }, {
                              "name": "salesqty",
                              "itemId": "salesqty",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sales qty",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales qty<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "1C834ABC-C457-44D6-8789-C23871DBC197",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "salesqty",
                              "columnWidth": 0.5,
                              "bind": "{salesqty}"
                         }, {
                              "name": "netsalesamt",
                              "itemId": "netsalesamt",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Net sales amt",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Net sales amt<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "162D2432-B19D-4067-9AC0-92630CBE5D1F",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "netsalesamt",
                              "columnWidth": 0.5,
                              "bind": "{netsalesamt}"
                         }, {
                              "name": "grosssalesamt",
                              "itemId": "grosssalesamt",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Gross sales amt",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Gross sales amt<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "0B018828-19E2-4783-AB98-9979C70313E2",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "grosssalesamt",
                              "columnWidth": 0.5,
                              "bind": "{grosssalesamt}"
                         }, {
                              "name": "materialcode",
                              "itemId": "materialcode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Material code",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Material code<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "17DED33B-56D3-418A-8259-00B46DDC3F9C",
                              "restURL": "Material",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.MaterialModel"
                              },
                              "bindable": "materialcode",
                              "columnWidth": 0.5,
                              "bind": "{materialcode}"
                         }, {
                              "name": "brandcode",
                              "itemId": "brandcode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Brand code",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Brand code<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "CFAB97D5-6CF1-4275-84B5-EDEDCD58F896",
                              "restURL": "Brand",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.BrandModel"
                              },
                              "bindable": "brandcode",
                              "columnWidth": 0.5,
                              "bind": "{brandcode}",
                              "listeners": {
                                   "change": "onBrandcodeChange"
                              }
                         }, {
                              "name": "category",
                              "itemId": "category",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Category",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Category<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E26FD5B2-7ADE-46BF-99BA-34DA082A6900",
                              "restURL": "Category",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Salesdemoapp.salesdemoapp.shared.com.model.sales.CategoryModel"
                              },
                              "bindable": "category",
                              "columnWidth": 0.5,
                              "bind": "{category}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "31A73DC0-3659-4786-B7A8-083AA64ABA1A",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "viewModel": "SalesDataViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});