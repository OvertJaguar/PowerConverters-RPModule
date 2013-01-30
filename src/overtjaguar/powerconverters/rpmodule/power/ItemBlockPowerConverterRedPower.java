package overtjaguar.powerconverters.rpmodule.power;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockPowerConverterRedPower extends ItemBlock
{
	public ItemBlockPowerConverterRedPower(int id)
	{
		super(id);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public int getMetadata(int i)
	{
		return i;
	}

	@Override
	public int getIconFromDamage(int i)
	{
		return 0;
	}

	@Override
	public String getItemNameIS(ItemStack itemstack)
	{
		int md = itemstack.getItemDamage();
		if(md == 0) return "rp2Consumer";
		if(md == 1) return "rp2Producer";
		return "unknown";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i <= 1; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
}
