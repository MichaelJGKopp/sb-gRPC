package io.michaeljgkopp.github.stocktradingserver.repository;

import io.michaeljgkopp.github.stocktradingserver.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

  Stock findByStockSymbol(String stockSymbol);
}
