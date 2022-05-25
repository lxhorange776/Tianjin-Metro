package ziyue.tjmetro;

import mtr.RegistryClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import ziyue.tjmetro.packet.IPacket;
import ziyue.tjmetro.packet.PacketGuiClient;
import ziyue.tjmetro.render.RenderStationNameSign;

public class MainClient
{
	public static void init() {
		RegistryClient.registerBlockRenderType(RenderType.cutout(), BlockList.LOGO.get());
		RegistryClient.registerBlockRenderType(RenderType.cutout(), BlockList.STATION_NAME_SIGN_1.get());
		RegistryClient.registerBlockRenderType(RenderType.cutout(), BlockList.STATION_NAME_SIGN_2.get());
		RegistryClient.registerBlockRenderType(RenderType.translucent(), BlockList.ROLLING.get());
		RegistryClient.registerBlockRenderType(RenderType.cutout(), BlockList.PLATFORM_TJ_1.get());
		RegistryClient.registerBlockRenderType(RenderType.cutout(), BlockList.PLATFORM_TJ_1_INDENTED.get());
		RegistryClient.registerBlockRenderType(RenderType.cutout(), BlockList.PLATFORM_TJ_2.get());
		RegistryClient.registerBlockRenderType(RenderType.cutout(), BlockList.PLATFORM_TJ_2_INDENTED.get());

		RegistryClient.registerBlockColors(BlockList.STATION_COLOR_CEILING.get());
		RegistryClient.registerBlockColors(BlockList.STATION_COLOR_CEILING_LIGHT.get());
		RegistryClient.registerBlockColors(BlockList.STATION_COLOR_CEILING_NO_LIGHT.get());
		RegistryClient.registerBlockColors(BlockList.STATION_NAME_SIGN_1.get());

		RegistryClient.registerTileEntityRenderer(BlockEntityTypes.STATION_NAME_SIGN_ENTITY_1.get(), RenderStationNameSign::new);
		RegistryClient.registerTileEntityRenderer(BlockEntityTypes.STATION_NAME_SIGN_ENTITY_2.get(), RenderStationNameSign::new);

		RegistryClient.registerNetworkReceiver(IPacket.PACKET_OPEN_CUSTOM_CONTENT_SCREEN, packet -> PacketGuiClient.openCustomContentScreenS2C(Minecraft.getInstance(), packet));
	}
}
