package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(89);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("JKCPWxBBfObYdBiyiweHlLLaXiZ7QPjrLnYQaJDsCj9UU3r7kV");
            corecontacts.setFirstName("SilQTkEvlPUt0QsOuhZxKzQo2nRH0t1tnQP8ROB6gQaz1OPNot");
            Gender gender = new Gender();
            gender.setGender("OE6kjZ86ZEbB7pS5IiJRTrkOqYVt0w6lanEZoplm2Bn0Ln9huc");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("G2");
            language.setAlpha3("BiS");
            language.setAlpha4("Xjb0");
            language.setAlpha4parentid(9);
            language.setLanguage("8hzS2zPwjFgZ45JCTNM537JJh4ShPM1ItimObKtTbLfX9HmdOz");
            language.setLanguageDescription("xJLrZtlZjKc4vbkMtouA4D5WcIdXat9WPP3QJxqzkjlituR8v2");
            language.setLanguageIcon("Kvtz19Sczoy1iOHluQUd6A3znuPGbMjtf2cE0Kt2dRTdgKHw5U");
            language.setLanguageType("9IgyCUR3zk5mPHYb2MOwLqpghwhVzCFt");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("xHstxv0vlG4Sk6kehiQ6pNeIQkzjC1JxCpf4IGkIULCJo5EsBW");
            timezone.setCountry("6U1DOLRzMYrKsxNAJGkOeJ3S9HrWBJJ2VCS2uYoDKdD1IdMByX");
            timezone.setGmtLabel("r9f9YdckIIVi8ExC7XNAz5Hm1AnEKBoLkOeya9eyv8N7CGdMZn");
            timezone.setTimeZoneLabel("4pEu5w3C0HDT8GU2Oth5RsCaKRQYFcS2ZYrSKHwGopHhAHkLWN");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("VxISbBwQsnl8RE0TqTxydsUR0HAFBzy7vpa3tegpMCIqlk8P5o");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(41);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("WqPfsW3USwfYkCkRjsY76rProW5vneZoBhsqGm9diaioYHTInF");
            corecontacts.setFirstName("DwI8JS5YyWUdTgsuyhXbqmX4lvmDMpdgcW3EkXTM6sHhuajuq9");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("AidcBSM5FrSZ0FkVjX2ZHgkSnAR6DT4h1NfubTHLQyiarjDoYL");
            corecontacts.setMiddleName("12P0WTnGqa0verDy7j7WChoUIfOxKG2V7h9ZlVs2b2aNPXHdTg");
            corecontacts.setNativeFirstName("WffPU31HHSKeMnqLfme6EWaVFRCRnlwj2F8L09CWXAEOq0kump");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("BTWsBE1MF7H9lTk5a1hIKhJa2OZRCi4N0kcxk3Ob5ogl4jFl5s");
            corecontacts.setNativeMiddleName("NuWl4ZDiYD4abHIArhOXXypEaX5ce7DlKG7YGMX4GdeY1hTjNQ");
            corecontacts.setNativeTitle("DG38fgWJsU1JegNSnU2i9VZhKcQlQSBhNKFUwgcVYp4Es4MzTn");
            corecontacts.setPhoneNumber("VR2SHqkCxL3cSIZJNGib");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("WiFnRkeUJWq7wDOLlEIy56TmGFBuT0p3GIQMJT4pxJ0sC2bDHL");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2819);
            user.setUserAccessCode(2);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("YtCPNQFkzCAjmu3F6iG1aLdI4DmF0a0uj29E39MwSuB9nD36wa");
            useraccessdomain.setDomainHelp("Sv5pMAOgmPd3Ypc58B3zrp0IM9dlnLFMFuUinziIbVYEtUkk5q");
            useraccessdomain.setDomainIcon("2Wdzp9zpbI6Hd53ogGUoHAubmWXrbSPP8vdvpUlMRaj5aFX5QS");
            useraccessdomain.setDomainName("6EPVPaiHPtfWbwk7TDWB0kO154wxMJ5x0rFpejTF0kfbk5lSQU");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("dWm0CDeL9jm6Id2DUKPoS9c43W2a4chYMx2ExgMeejl1rwtzIY");
            useraccesslevel.setLevelHelp("24Foe6IcnomAoiNNs3dLaCnolFntsdt7SBrBn0V3r7UHynqvsn");
            useraccesslevel.setLevelIcon("mXN3svGshZJ7M5w394no3wemO5CogD8N3QyInOfxzP3EKiicjv");
            useraccesslevel.setLevelName("jNZL59VH7y53ljM2gfyRCYj9tyffOFwvgYX6NUMBDYJcxmBuDN");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("63ni5oDNpdDQjF1WHFdoF0Qxyoz2FrvhExNn9UuELMq0zf6G8A");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(351);
            user.setUserAccessCode(7);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(2);
            login.setIsAuthenticated(true);
            login.setLoginId("nr99pMu4zeflJgi8W2evFa2u2NtRm82jiHVcJFTmthjeVTwnG7");
            login.setServerAuthImage("Qb1OXJVxGjbfiDmPuBUFLJw8YQlNIkuT");
            login.setServerAuthText("du3NRWvrEoQAbixd");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(7);
            login.setLoginId("WhF6AZrQC4uIMIWtcYuIIII3eAUIw3zo72H5wPgnV3WSMBccY1");
            login.setServerAuthImage("s52343g315OkJ4d6eqwV30JNRrKJhMbA");
            login.setServerAuthText("lngI0lmVI17XKouQ");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
