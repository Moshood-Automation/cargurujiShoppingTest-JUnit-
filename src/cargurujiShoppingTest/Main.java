package cargurujiShoppingTest;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
        ChangePasswordTest obj = new  ChangePasswordTest();
        obj.setUp();
        obj.ChangePassword();
        obj.TearDown();
		
		RegisterTest obj1 = new RegisterTest();
		obj1.setUp();
		obj1.RegisterNewuser();
		obj1.TearDown();
	
		SignInTest obj2 = new SignInTest();
		obj2.setUp();
		obj2.SignInWithValidDetails();
		obj2.TearDown();
		
	    obj2.setUp();
		obj2.SignInWithValidEmailAndInvalidPassword();
		obj2.TearDown();
		
		obj2.setUp();
		obj2.SignInWithInvalidEmailAndValidPassword();
		obj2.TearDown();
		
		obj2.setUp();
		obj2.SignInWithBlankEmailAndPassword();
		obj2.TearDown();
		
		LandingPageLogoTest obj3 = new LandingPageLogoTest();
		obj3.setUp();
		obj3.VerifyPageLogos();
		obj3.tearDown();
	}

}
