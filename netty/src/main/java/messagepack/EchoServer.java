package messagepack;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author qihaodong
 */
public class EchoServer {

    public static void main(String[] args) {
        new EchoServer().init();
    }

    private static final int PORT = 8888;

    private void init() {
        EventLoopGroup bossGroup = null;
        EventLoopGroup workerGroup = null;
        try {
            bossGroup = new NioEventLoopGroup();
            workerGroup = new NioEventLoopGroup();
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast("msgpack decoder", new MsgPackDecoder());
                            socketChannel.pipeline().addLast("msgpack encoder", new MsgPackEncoder());
                            socketChannel.pipeline().addLast(new ChannelHandlerAdapter() {
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    System.out.println("服务端含有待读取信息");
                                    System.out.println("Server Receive message：" + msg.toString());
                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                    ctx.close();
                                }
                            });
                        }
                    });
            ChannelFuture future = bootstrap.bind(PORT).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
