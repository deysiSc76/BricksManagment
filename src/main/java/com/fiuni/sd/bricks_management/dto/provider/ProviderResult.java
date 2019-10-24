package com.fiuni.sd.bricks_management.dto.provider;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.bricks_management.dto.base.BaseResult;

@XmlRootElement(name = "providerResult")
public class ProviderResult extends BaseResult<ProviderDTO> {
	private static final long serialVersionUID = 1L;
}
