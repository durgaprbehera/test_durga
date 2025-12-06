package mcp;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.spec.McpSchema;

import java.time.Duration;
import java.util.Map;

public class ChromeMCPTest {

    public static void main(String[] args) {
        // Spawn the MCP server (Chrome DevTools MCP via npx)
        ServerParameters params = ServerParameters.builder("cmd.exe")
                .args("/c", "npx", "-y", "chrome-devtools-mcp@latest")
                //.env(Map.of("DEBUG", "1"))
                .build();

        // 1. Define the server command (often involves 'npx')
        String commandText = "npx chrome-devtools-mcp@latest";

        // 2. Get the default JSON mapper instance
        McpJsonMapper jsonMapper = McpJsonMapper.getDefault();

        // 3. Instantiate the transport with BOTH required arguments
        StdioClientTransport transport = new StdioClientTransport(params, jsonMapper);

        // 4. Create and initialize a synchronous client
        McpSyncClient client = McpClient.sync(transport)
                .requestTimeout(Duration.ofSeconds(90))
                .build();

        try {
            client.initialize();

            McpSchema.ListToolsResult tools = client.listTools();
            tools.tools().forEach(t -> System.out.println("Tool: " + t.name()));

            // 5. Call a tool exposed by the Chrome DevTools MCP server
            Map<String, Object> params1 = Map.of("url", "https://www.google.com");
            McpSchema.CallToolRequest request = new McpSchema.CallToolRequest("navigate_page", params1);

            McpSchema.CallToolResult result = client.callTool(request);

            System.out.println("Navigation result: " + result.content());
        } finally {
            // 6) Graceful close
            try {
                client.closeGracefully();
            } catch (Exception ignored) {
                System.out.println(ignored.getMessage());
            }
//            try {
//                transport.close();
//            } catch (Exception ignored) {
//                System.out.println(ignored.getMessage());
//            }

            // 7) Fallback: force-kill if the server didn’t exit
            //    (Java 9+; kills the npx/mcp process tree if still alive)
            //forceKillIfStillRunning("chrome-devtools-mcp");
            //forceKillIfStillRunning("chrome.exe"); // if Chrome got stuck
        }

    }

    private static void forceKillIfStillRunning(String match) {
        ProcessHandle.allProcesses()
                .filter(ph -> ph.info().commandLine().orElse("").contains(match))
                .forEach(ph -> {
                    ph.destroy();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ignored) {
                    }
                    if (ph.isAlive()) ph.destroyForcibly();
                });
    }
}
