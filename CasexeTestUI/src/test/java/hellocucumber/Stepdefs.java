package hellocucumber;




import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import static org.junit.Assert.*;

public class Stepdefs extends BasicActions {
    private String login;
    private String password;
    private String url;
    private String sortText;
    
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

    		@Дано("существует игрок с Username: {string}")
    		public void существует_игрок_с_Username_(String player) {
    			this.sortText = player;
    		}

    		@Когда("я ввел имя игрока в поле сортировки столбца Username и нажал Enter")
    		public void я_ввел_имя_игрока_в_поле_сортировки_столбца_Username_и_нажал_Enter(){
    			SearchByUserName(sortText);
    		}

    		@То("таблица верно отсортировалась и выдала одного игрока с данным Username")
    		public void таблица_верно_отсортировалась_и_выдала_одного_игрока_с_данным_Username() {
    			CheckSortByUserName (sortText);
    		}
    		@Дано("существуют игроки, Username которых содержит текст: {string}")
    		public void существуют_игроки_Username_которых_содержит_текст(String sortText) {
    			this.sortText = sortText;
    		}

    		@Когда("я ввел этот текст в поле сортировки столбца Username и нажал Enter")
    		public void я_ввел_этот_текст_в_поле_сортировки_столбца_Username_и_нажал_Enter(){
    			SearchByUserName(sortText);
    		}

    		@То("таблица верно отсортировалась и выдала игроков, Username которых содержит этот текст")
    		public void таблица_верно_отсортировалась_и_выдала_игроков_Username_которых_содержит_этот_текст() {
    			CheckSortByUserName (sortText);
    		}
    		
    		@То("таблица верно отсортировалась и невыдала ни одного игрока с данным Username")
    		public void таблица_верно_отсортировалась_и_невыдала_ни_одного_игрока_с_данным_Username() {
    			CheckSortByUserName (sortText);
    		}
    		
}
