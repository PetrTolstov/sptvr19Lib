/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;

import tools.History;
import tools.HistorySaver;

/**
 *
 * @author user
 */
class HistoryManager {

    void saveHistory(History history, History[] histories) {
        for(int h = 0; h < histories.length; h++){
                        if(histories[h] == null){
                            histories [h] = history;
                            
                            HistorySaver hsaver = new HistorySaver();
                            hsaver.saveBook(histories);
                            break;
                        }
                    }
    }

    void printListHistory(History[] histories) {
        for (int j = 0; j < histories.length; j++) {
                        if(histories[j] != null && histories[j].getReturnDate() == null){
                            System.out.printf("%3d. Читатель: %s%nНазвание книги: %s%nНачальная дата: %s%n Конечная дата: %s%n "
                                    ,j+1
                                    ,histories[j].getReader().getName()
                                    ,histories[j].getBook().getName()
                                    ,histories[j].getTakeOnDate()
                                    ,histories[j].getReturnDate()
                            );
                            System.out.println("--------------------------------");
                            
                        }
                    }
    }
    
}
