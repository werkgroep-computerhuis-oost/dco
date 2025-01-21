package com.github.computerhuis.dco.web;

import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.springframework.data.domain.Page;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Getter
@Setter
public abstract class PageableView<T> {

    protected String search;
    protected Page<T> data;

    // --[ page number helpers ]----------------------------------------------------------------------------------------
    public int getTotalPages() {
        return Math.max(data.getTotalPages(), 0);
    }

    public long getTotalElements() {
        return data.getTotalElements();
    }

    public int getCurrentPageNumber() {
        return data.getNumber();
    }

    public Integer getPreviousPageNumber() {
        val number = data.getNumber() - 1;
        if (number < 0) {
            return null;
        }
        return number;
    }

    public Integer getNextPageNumber() {
        val number = data.getNumber() + 1;
        if (number < data.getTotalPages()) {
            return number;
        }
        return null;
    }

    public String getPageSizeUrl(final Integer pageSize) {
        return getUrl(search, pageSize, null);
    }

    public Integer getPageSize() {
        return data.getSize();
    }

    public String getPageUrl(final Integer page) {
        return getUrl(search, data.getSize(), page);
    }

    public String getUrl(final String search,
                         final Integer pageSize,
                         final Integer pageNumber) {
        val result = new StringBuilder();

        if (isNotBlank(search)) {
            result.append("&search=").append(search.replaceAll("\\s+", "+"));
        }

        if (pageNumber != null && pageNumber > 0) {
            result.append("&page=").append(pageNumber);
        }

        if (pageSize != null && pageSize > 0) {
            result.append("&page-size=").append(pageSize);
        }

        val resultString = result.toString();
        if (isNotBlank(resultString)) {
            return "?" + resultString.substring(1);
        }
        return null;
    }
}
