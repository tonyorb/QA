package ru.gorbunov;




import org.openqa.selenium.By;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import static org.junit.Assert.*;



class IsItFriday {
	static String isItFriday(String today) {
	    return "Friday".equals(today) ? "TGIF" : "Nope";
	}
}

public class Stepdefs extends BasicActions {
    private String login;
    private String password;
    private String url;
    private String player;
    
		    @Дано("существует пользователь с логином: {string} и паролем: {string} на ресурсе {string}")
		    public void существует_пользователь_с_логином_и_паролем(String login, String password, String url) {
		    	OpenUrl("http://test-app.d6.dev.devcaz.com/admin/login");
		        this.login = login;
		        this.password = password;
		        this.url = url;
		    }

    		@Когда("я ввел логин и пароль пользователя на странице авторизации и нажал на кнопку Sign in")
    		public void я_ввел_логин_и_пароль_пользователя_на_странице_авторизации_и_нажал_на_кнопку_Sign_in() {
    			OpenUrl(url);
    			LogIn(login,password);
    		}

			@То("я авторизовался как пользователь")
    		public void я_авторизовался_как_пользователь() {
				assertEquals(login, GetActualLogin());
    		}

    		@То("админ-панель загрузилась")
    		public void админ_панель_загрузилась() {
    			assertEquals(15,GetAdminPanelRowsCount());
    		}

    		@Когда("я открыл список игроков")
    		public void я_открыл_список_игроков() {
    			OpenPlayersList();
    		}

    		@То("таблица с игроками загрузилась")
    		public void таблица_с_игроками_загрузилась() {
    			assertNotEquals(GetPlayersTableRowCount(),0);
    		}

    		@Дано("существет игрок с Username: {string}")
    		public void существет_игрок_с_Username_xzibit(String player) {
    			this.player = player;
    		}

    		@Когда("я ввел имя игрока в поле сортировки столбца Username и нажал Enter")
    		public void я_ввел_имя_игрока_в_поле_сортировки_столбца_Username_и_нажал_Enter()
    		 {
    			SearchByUserName(player);
    		}

    		@То("таблица верно отсортировалась и выдала одного игрока с данным Username")
    		public void таблица_верно_отсортировалась_и_выдала_одного_игрока_с_данным_Username() {
    			assertEquals(1,GetPlayersTableRowCount());
    		}
}
