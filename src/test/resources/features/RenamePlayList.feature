Feature: Playlist tests

Scenario: Rename playlist test
  Given I open browser
  When I input email "demo@class.com"
  And I input password "te$t$tudent"
  And I click submit
  And I double click by playlist of number 1
  And I enter new playlist name "Test Pro Edited Playlist"
  Then Playlist "Test Pro Edited Playlist" should be exist