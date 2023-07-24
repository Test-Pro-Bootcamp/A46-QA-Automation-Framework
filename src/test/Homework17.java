public class Homework17 extends BaseTest {
    @Test
    public void addSongtoPlaylist() {
        String newSongAddedNotification = "Added 1 song into";
        navigatetoPage();
        provideEmail("daria.pavlyuk@test.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong(songTitleKeyword "Pluto");
        viewAllSearchResults();
        selectFirstSongResult();
        clickAddButton();
        choosePlaylist(playlistName "Daria's playlist");
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));



    }
}
