package com.jimmy.wishlistapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\tH\'J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u000f"}, d2 = {"Lcom/jimmy/wishlistapp/data/WishDao;", "", "()V", "addWish", "", "wishEntity", "Lcom/jimmy/wishlistapp/data/Wish;", "deleteAWish", "getAWishById", "Lkotlinx/coroutines/flow/Flow;", "id", "", "getAllWishes", "", "updateAWish", "app_debug"})
@androidx.room.Dao()
public abstract class WishDao {
    
    public WishDao() {
        super();
    }
    
    @androidx.room.Insert(onConflict = 5)
    public abstract void addWish(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.Wish wishEntity);
    
    @androidx.room.Query(value = "Select * from `wish-table`")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.jimmy.wishlistapp.data.Wish>> getAllWishes();
    
    @androidx.room.Update()
    public abstract void updateAWish(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.Wish wishEntity);
    
    @androidx.room.Delete()
    public abstract void deleteAWish(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.Wish wishEntity);
    
    @androidx.room.Query(value = "Select * from `wish-table` where id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.jimmy.wishlistapp.data.Wish> getAWishById(long id);
}