//import io.netty.bootstrap.Bootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//
//import java.util.Date;
//import java.util.Scanner;
//import java.util.concurrent.TimeUnit;
//
//public class NettyClient {
//
//    private static final int MAX_RETRY = 5;
//
//    public static void main(String[] args) {
//
//        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
//
//
//        Bootstrap bootstrap = new Bootstrap();
//
//        bootstrap
//
//                // 1.指定线程模型
//
//                .group(workerGroup)
//
//                // 2.指定 IO 类型为 NIO
//
//                .channel(NioSocketChannel.class)
//
//                // 3.IO 处理逻辑
//
//                .handler(new ChannelInitializer<SocketChannel>() {
//
//                    @Override
//
//                    public void initChannel(SocketChannel ch) {
//                        ch.pipeline().addLast(new FirstClientHandler());
//
//                    }
//
//                });
//        connect(bootstrap,"localhost",6666,MAX_RETRY);
//
//    }
//
//        // 4.建立连接
//    private static  void connect(Bootstrap bootstrap,String host,int port,int retry){
//            bootstrap.connect(host, port).addListener(future -> {
//
//                if (future.isSuccess()) {
//                    Channel channel = ((ChannelFuture) future).channel();
//                    System.out.println("连接成功!");
//                    startConsoleThread(channel);
//
//                } else if (retry==0){
//
//                    System.err.println("连接失败!");
//
//                }else {
//                    int order = (MAX_RETRY - retry) +1;
//
//                    int delay = 1 << order;
//                    System.out.println(new Date() + ":连接失败,第" + order +"次重连..... ");
//                    bootstrap.config().group().schedule(()-> connect(bootstrap,host,port,retry-1),delay, TimeUnit.SECONDS);
//                }
//
//
//            });
//        }
//
//    private static void startConsoleThread(Channel channel) {
//
//        new Thread(() -> {
//
//            while (!Thread.interrupted()) {
//
//                    System.out.println("输入消息发送至服务端: ");
//
//                    Scanner sc = new Scanner(System.in);
//
//                    String line = sc.nextLine();
//
//
//
//                    MessageRequestPacket packet = new MessageRequestPacket();
//
//                    packet.setMessage(line);
//
//                    ByteBuf byteBuf = PacketCodeC.encode( packet);
//
//                    channel.writeAndFlush(byteBuf);
//
//
//
//            }
//
//        }).start();
//
//    }
//
//
//
//}
//
//
