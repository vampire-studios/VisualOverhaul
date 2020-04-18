package io.github.vampirestudios.visualoverhaul.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FluidRenderer.class)
public abstract class FluidRendererMixin {

    @Shadow @Final private Sprite[] lavaSprites;
    @Shadow @Final private Sprite[] waterSprites;

    /**
     * @author Olivia
     */
    @Overwrite
    public boolean render(BlockRenderView world, BlockPos pos, VertexConsumer vertexConsumer, FluidState state) {
        if (state.matches(FluidTags.WATER)) {
           /*BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
            MinecraftClient.getInstance().getTextureManager().bindTexture(waterSprites[0].getId());
            bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE);
            bufferBuilder.vertex(1.0F, 1.0F, 1.0F).color(255, 255, 255, 255).texture(0, 0).next();
            bufferBuilder.vertex(1.0F, 1.0F, 1.0F).color(255, 255, 255, 255).texture(0, 0).next();
            bufferBuilder.vertex(1.0F, 1.0F, 1.0F).color(255, 255, 255, 255).texture(0, 0).next();
            bufferBuilder.vertex(1.0F, 1.0F, 1.0F).color(255, 255, 255, 255).texture(0, 0).next();
            this.method_22978(bufferBuilder);
            bufferBuilder.end();
            BufferRenderer.draw(bufferBuilder);*/
            return true;
        }
        return false;
    }

    private void method_22978(BufferBuilder bufferBuilder, double d, double e, double f, double g, int i, double h, float j, float k) {
        bufferBuilder.vertex(g - d, (double)i - e, h - f).texture(j, k).next();
    }

}
