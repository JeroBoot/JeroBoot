package com.jero.web.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jero.web.base.entity.BaseEntity;
import com.jero.web.core.http.page.PageInfo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 基础控制器，包含处理分页等方法
 *
 * @author zero
 * @date 2020-03-25
 */
public abstract class BaseController<T extends BaseEntity<?>> {

    public BaseController() {
    }

    public final T getById(Serializable id) {
        return this.getService().getById(id);
    }

    public final List<T> list(T t) {
        QueryWrapper query = Wrappers.query(t);
        this.expandQuery(query, t);
        return this.getService().list(query);
    }

    public final PageInfo<T> page(PageInfo pageInfo, T t) {
        Page page = getPage(pageInfo);
        QueryWrapper query = Wrappers.query(t);
        this.expandQuery(query, t);
        Page resultPage = this.getService().page(page, query);
        return getPageInfo(resultPage);
    }

    public final boolean save(T data) {
        this.verifySaveData(data);
        return this.getService().save(data);
    }

    public final boolean update(T data) {
        this.verifyUpdateData(data);
        return this.getService().updateById(data);
    }

    public final boolean deleteBatchIds(Serializable... ids) {
        return this.getService().removeByIds(Arrays.asList(ids));
    }

    protected abstract void expandQuery(QueryWrapper query, T t);

    protected abstract void verifySaveData(T data);

    protected abstract void verifyUpdateData(T data);

    public PageInfo<T> getPageInfo(IPage<T> page) {
        PageInfo<T> pageInfo = new PageInfo();
        pageInfo.setList(page.getRecords());
        pageInfo.setCount(page.getTotal());
        pageInfo.setPageSize((int) page.getSize());
        pageInfo.setPageCount(page.getPages());
        pageInfo.setPageNo((int) page.getCurrent());
        return pageInfo;
    }

    public Page getPage(PageInfo pageInfo) {
        Page page = new Page();
        page.setSize(pageInfo.getPageSize());
        page.setCurrent(pageInfo.getPageNo());

        return page;
    }

    protected abstract IService<T> getService();

}
