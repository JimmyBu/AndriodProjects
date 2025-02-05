package com.jimmy.wishlistapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000eJ\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013\u00a8\u0006%"}, d2 = {"Lcom/jimmy/wishlistapp/WishViewModel;", "Landroidx/lifecycle/ViewModel;", "wishRepository", "Lcom/jimmy/wishlistapp/data/WishRepository;", "(Lcom/jimmy/wishlistapp/data/WishRepository;)V", "getAllWishes", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/jimmy/wishlistapp/data/Wish;", "getGetAllWishes", "()Lkotlinx/coroutines/flow/Flow;", "setGetAllWishes", "(Lkotlinx/coroutines/flow/Flow;)V", "<set-?>", "", "wishDescriptionState", "getWishDescriptionState", "()Ljava/lang/String;", "setWishDescriptionState", "(Ljava/lang/String;)V", "wishDescriptionState$delegate", "Landroidx/compose/runtime/MutableState;", "wishTitleState", "getWishTitleState", "setWishTitleState", "wishTitleState$delegate", "addWish", "", "wish", "deleteWish", "getAWishById", "id", "", "onWishDescriptionChanged", "newString", "onWishTitleChanged", "updateWish", "app_debug"})
public final class WishViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.jimmy.wishlistapp.data.WishRepository wishRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState wishTitleState$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState wishDescriptionState$delegate = null;
    public kotlinx.coroutines.flow.Flow<? extends java.util.List<com.jimmy.wishlistapp.data.Wish>> getAllWishes;
    
    public WishViewModel(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.WishRepository wishRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWishTitleState() {
        return null;
    }
    
    public final void setWishTitleState(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWishDescriptionState() {
        return null;
    }
    
    public final void setWishDescriptionState(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final void onWishTitleChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String newString) {
    }
    
    public final void onWishDescriptionChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String newString) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.jimmy.wishlistapp.data.Wish>> getGetAllWishes() {
        return null;
    }
    
    public final void setGetAllWishes(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends java.util.List<com.jimmy.wishlistapp.data.Wish>> p0) {
    }
    
    public final void addWish(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.Wish wish) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.jimmy.wishlistapp.data.Wish> getAWishById(long id) {
        return null;
    }
    
    public final void updateWish(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.Wish wish) {
    }
    
    public final void deleteWish(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.Wish wish) {
    }
    
    public WishViewModel() {
        super();
    }
}