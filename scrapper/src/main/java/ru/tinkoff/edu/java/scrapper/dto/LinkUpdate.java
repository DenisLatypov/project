package ru.tinkoff.edu.java.scrapper.dto;

import java.net.URI;

public record LinkUpdate(Long id, URI url, String description, Long[] tgChatIds) {}
