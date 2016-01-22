Ext.define('Mineproj.view.usermanagement.enduser.ChangePwdController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.changePwdController',

	validatePassword : function() {
		
		var newPassword = this.getView().down('#newPassword').getValue();
		var reTypeNewPassword = this.getView().down('#reTypeNewPassword').getValue();
		if (newPassword == reTypeNewPassword)
			return true;
		else
			return "Passwords do not match!";
	},

	onChangePasswordClick : function(btn, opts) {
		
		var form = btn.up().up();
		if (form.isValid()) {
			var formData = form.getValues();
			delete formData.reTypeNewPassword;

			var entMask = new Ext.LoadMask({
				msg : 'Updating...',
				target : this.getView()
			}).show();

			Ext.Ajax.request({
				timeout : 180000,
				url : "secure/PasswordGenerator/changePassword",
				method : 'PUT',
				waitMsg : 'Updating...',
				entMask : entMask,
				jsonData : formData,
				me : this,
				success : function(response, sender) {
					var responseText = Ext.JSON.decode(response.responseText);
					if (responseText.response.success) {
						Ext.Msg.alert("Info", responseText.response.message);
						sender.entMask.hide();
						sender.me.onResetPasswordClick();
						this.location.reload();
					} else {
						Ext.Msg.alert("Info", responseText.response.message);
						sender.entMask.hide();
					}
				},
				failure : function(response, sender) {
					
					Ext.Msg.alert("ERROR", "Cannot connect to server");
					sender.entMask.hide();
				}
			});
		}
	},

	onResetPasswordClick : function(btn, opts) {
		this.getView().down('#oldPassword').reset();
		this.getView().down('#newPassword').reset();
		this.getView().down('#reTypeNewPassword').reset();
	}
});