package overtjaguar.powerconverters.rpmodule.power;

import java.util.Map.Entry;

import net.minecraftforge.common.ForgeDirection;

import overtjaguar.powerconverters.rpmodule.RPModule;

import com.eloraam.redpower.machine.TileBatteryBox;

import powercrystals.powerconverters.power.TileEntityEnergyConsumer;

public class TileEntityRedPowerConsumer extends TileEntityEnergyConsumer<TileBatteryBox>
{
	private int _btLastTick;

	public TileEntityRedPowerConsumer()
	{
		super(RPModule.powerSystemRedPower, 0, TileBatteryBox.class);
	}

	@Override
	public void updateEntity()
	{
		super.updateEntity();

		_btLastTick = 0;
		for(Entry<ForgeDirection, TileBatteryBox> box : getTiles().entrySet())
		{
			int toStore = Math.min(box.getValue().Storage, getTotalEnergyDemand() / getPowerSystem().getInternalEnergyPerInput());
			box.getValue().Storage -= toStore;
			storeEnergy(toStore * getPowerSystem().getInternalEnergyPerInput());
			_btLastTick += toStore;
		}
	}

	@Override
	public int getInputRate()
	{
		return _btLastTick;
	}
}
