package top.seacolo.service;

import top.seacolo.entity.Hero_attribute;
import top.seacolo.util.ReturnSty;

import java.util.List;

public interface HeroAttrService {
    ReturnSty<List<Hero_attribute>> SelectAllHeroAttr();
}
