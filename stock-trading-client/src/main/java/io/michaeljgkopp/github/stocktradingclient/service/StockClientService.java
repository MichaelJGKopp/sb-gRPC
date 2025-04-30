package io.michaeljgkopp.github.stocktradingclient.service;

import io.michaeljgkopp.github.grpc.StockResponse;
import io.michaeljgkopp.github.grpc.StockRequest;
import io.michaeljgkopp.github.grpc.StockTradingServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class StockClientService {

  @GrpcClient("stockService")
  private StockTradingServiceGrpc.StockTradingServiceBlockingStub serviceBlockingStub;

  public StockResponse getStockPrice(String stockSymbol) {
    StockRequest request = StockRequest.newBuilder()
        .setStockSymbol(stockSymbol)
        .build();
    return serviceBlockingStub.getStockPrice(request);
  }
}