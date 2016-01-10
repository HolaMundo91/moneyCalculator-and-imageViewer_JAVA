package controller;

import model.ExchangeRate;
import model.DatabaseConnection;
import process.Exchanger;
import ui.ExchangeDialog;
import swing.MoneyDisplay;


public class ExchangeOperation {
    private final ExchangeDialog dialog;

    public ExchangeOperation(ExchangeDialog dialog) {
        this.dialog = dialog;
    }
    
    public void execute(DatabaseConnection dbSQlite) {
        ExchangeRate exchangeRate = dbSQlite.getExchangeRate(
                dialog.getExchange().getMoney().getCurrency(),
                dialog.getExchange().getCurrency()
        );
        
        new MoneyDisplay(Exchanger.exchangeRate(dialog.getExchange().getMoney(), exchangeRate));
    }
    
}
