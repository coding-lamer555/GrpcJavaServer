package me.codinglamer.grpcjavaserver;

import io.grpc.stub.StreamObserver;

public class PostServiceImpl extends PostServiceGrpc.PostServiceImplBase {

    @Override
    public void getPosts(PostServiceOuterClass.PostRequest request,
                         StreamObserver<PostServiceOuterClass.PostResponse> responseObserver) {
        for (int i = 1; i <= 10000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            PostServiceOuterClass.PostResponse response = PostServiceOuterClass.PostResponse
                    .newBuilder()
                    .setId(i)
                    .setTitle("Title" + i)
                    .setDescription("Description" + i)
                    .build();

            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }
}