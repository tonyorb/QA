package ru.gorbunov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ApiTest extends BasicActions
{	
	@Test
    public void testApi()
    {
		String AccessToken = GetGuestToken();
		Assert.assertNotNull("Токен гостя не получен", AccessToken);
		Player player = RegisterANewRandomPlayer(AccessToken);
		String PlayerAccessToken = PlayerAuth(player.userName, player.userPassword);
		Assert.assertNotNull("Токен игрока не получен", PlayerAccessToken);
		GetPlayerProfile(player.userId, PlayerAccessToken);
		GetAnotherPlayerProfile(UserIdChange(player.userId), PlayerAccessToken);
    }

	@Before
	public void disableWarning() {
	    System.err.close();
	    System.setErr(System.out);
	}
}
