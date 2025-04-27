package io.michaeljgkopp.github.stocktradingserver.service;

import io.grpc.stub.StreamObserver;
import io.michaeljgkopp.github.grpc.StockRequest;
import io.michaeljgkopp.github.grpc.StockResponse;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class StockTradingServiceImpl extends
    io.michaeljgkopp.github.grpc.StockTradingServiceGrpc.StockTradingServiceImplBase {

  @Override
  public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver) {

    // stockname -> DB -> map response -> return
  }
}
