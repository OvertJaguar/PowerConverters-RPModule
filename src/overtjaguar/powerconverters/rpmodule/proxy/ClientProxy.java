package overtjaguar.powerconverters.rpmodule.proxy;

import overtjaguar.powerconverters.rpmodule.RPModule;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{


	@Override
	public void load()
	{

	}


	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture(RPModule.textureFile);
	}

}
