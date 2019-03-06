import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 处理服务器端通道
 */

public class NettyServer {

    public static void main(String[] args) {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        NioEventLoopGroup workerGroup = new NioEventLoopGroup();



        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap

                .group(bossGroup, workerGroup)

                .channel(NioServerSocketChannel.class)

                .childHandler(new ChannelInitializer<NioSocketChannel>() {

                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new FirstServerHandler());

                    }

                });



        serverBootstrap.bind(6666);

    }

}

