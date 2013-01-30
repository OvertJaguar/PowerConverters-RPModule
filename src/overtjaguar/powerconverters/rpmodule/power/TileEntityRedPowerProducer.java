package overtjaguar.powerconverters.rpmodule.power;

import java.util.Map.Entry;

import net.minecraftforge.common.ForgeDirection;

import com.eloraam.redpower.machine.TileBatteryBox;

import overtjaguar.powerconverters.rpmodule.RPModule;

import powercrystals.powerconverters.power.PowerSystem;
import powercrystals.powerconverters.power.TileEntityEnergyProducer;

public class TileEntityRedPowerProducer extends TileEntityEnergyProducer<TileBatteryBox>
{
	public TileEntityRedPowerProducer()
	{
		super(RPModule.powerSystemRedPower, 0, TileBatteryBox.class);
	}

	@Override
	public int produceEnergy(int energy)
	{

		for(Entry<ForgeDirection, TileBatteryBox> box : getTiles().entrySet())
		{
			int toStore = Math.min((box.getValue().getMaxStorage() -  box.getValue().Storage), energy / getPowerSystem().getInternalEnergyPerOutput());
			box.getValue().Storage += toStore;
			energy -= toStore * getPowerSystem().getInternalEnergyPerOutput();
		}
		return energy;
	}
}
