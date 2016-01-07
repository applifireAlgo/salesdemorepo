package com.app.shared.authorization;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.config.CacheIsolationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_Roles_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Roles", complexity = Complexity.LOW)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "roleId")
@NamedQueries({ @javax.persistence.NamedQuery(name = "Roles.findById", query = "select e from Roles e where e.systemInfo.activeStatus=1 and e.roleId =:roleId") })
public class Roles implements Serializable, CommonEntityInterface, Comparator<Roles> {

    @Column(name = "RoleName")
    @JsonProperty("roleName")
    @NotNull
    @Size(min = 0, max = 256)
    private String roleName;

    @Column(name = "RoleDescription")
    @JsonProperty("roleDescription")
    @NotNull
    @Size(min = 0, max = 256)
    private String roleDescription;

    @Column(name = "RoleIcon")
    @JsonProperty("roleIcon")
    @Size(min = 0, max = 64)
    private String roleIcon;

    @Column(name = "roleHelp")
    @JsonProperty("roleHelp")
    @Size(min = 0, max = 256)
    private String roleHelp;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "roleId")
    @JsonProperty("roleId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 3, max = 64)
    private String roleId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "roles")
    private RoleMenuBridge roleMenuBridge;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String _roleName) {
        if (_roleName != null) {
            this.roleName = _roleName;
        }
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String _roleDescription) {
        if (_roleDescription != null) {
            this.roleDescription = _roleDescription;
        }
    }

    public String getRoleIcon() {
        return roleIcon;
    }

    public void setRoleIcon(String _roleIcon) {
        this.roleIcon = _roleIcon;
    }

    public String getRoleHelp() {
        return roleHelp;
    }

    public void setRoleHelp(String _roleHelp) {
        this.roleHelp = _roleHelp;
    }

    public String getPrimaryKey() {
        return roleId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String _roleId) {
        this.roleId = _roleId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    public RoleMenuBridge getRoleMenuBridge() {
        return roleMenuBridge;
    }

    public void setRoleMenuBridge(RoleMenuBridge _roleMenuBridge) {
        if (_roleMenuBridge.getRoles() == null) {
            _roleMenuBridge.setRoles(this);
        }
        this.roleMenuBridge = _roleMenuBridge;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(Roles object1, Roles object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((roleName == null ? " " : roleName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (roleId == null) {
            return super.hashCode();
        } else {
            return roleId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.authorization.Roles other = (com.app.shared.authorization.Roles) obj;
            if (roleId == null) {
                return false;
            } else if (!roleId.equals(other.roleId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}
