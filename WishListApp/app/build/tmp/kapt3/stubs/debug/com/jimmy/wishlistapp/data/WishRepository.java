package com.jimmy.wishlistapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\fJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/jimmy/wishlistapp/data/WishRepository;", "", "wishDao", "Lcom/jimmy/wishlistapp/data/WishDao;", "(Lcom/jimmy/wishlistapp/data/WishDao;)V", "addAWish", "", "wish", "Lcom/jimmy/wishlistapp/data/Wish;", "(Lcom/jimmy/wishlistapp/data/Wish;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAWish", "getAWishById", "Lkotlinx/coroutines/flow/Flow;", "id", "", "getWishes", "", "updateAWish", "app_debug"})
public final class WishRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.jimmy.wishlistapp.data.WishDao wishDao = null;
    
    public WishRepository(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.WishDao wishDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addAWish(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.Wish wish, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.jimmy.wishlistapp.data.Wish>> getWishes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.jimmy.wishlistapp.data.Wish> getAWishById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateAWish(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.Wish wish, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAWish(@org.jetbrains.annotations.NotNull()
    com.jimmy.wishlistapp.data.Wish wish, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}