package io.michaeljgkopp.github.stocktradingserver.service;

import io.grpc.stub.StreamObserver;
import io.michaeljgkopp.github.grpc.StockRequest;
import io.michaeljgkopp.github.grpc.StockResponse;
import io.michaeljgkopp.github.stocktradingserver.entity.Stock;
import io.michaeljgkopp.github.stocktradingserver.repository.StockRepository;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class StockTradingServiceImpl extends
    // unary, one request one response
    io.michaeljgkopp.github.grpc.StockTradingServiceGrpc.StockTradingServiceImplBase {

  private final StockRepository stockRepository;

  public StockTradingServiceImpl(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  @Override
  public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver) {

    // stockname -> DB -> map response -> return

    String stockSymbol = request.getStockSymbol();
    Stock stockEntity = stockRepository.findByStockSymbol(stockSymbol);

    StockResponse stockResponse = StockResponse.newBuilder()
        .setStockSymbol(stockEntity.getStockSymbol())
        .setPrice(stockEntity.getPrice())
        .setTimestamp(stockEntity.getLastUpdated().toString())
        .build();

    responseObserver.onNext(stockResponse);
    responseObserver.onCompleted();
  }
}
