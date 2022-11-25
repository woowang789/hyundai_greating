$('.header__bottom .header__category .hover__menu > ul > li i').each(
  (idx, item) => {
    $(item).css('background-position-y', -275 - 25 * idx + 'px');
  }
);

